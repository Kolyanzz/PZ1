package com.example.pz1;

import android.os.Parcel;
import android.os.Parcelable;

import java.math.BigDecimal;

class Calculyator implements Parcelable {

    public static final Creator<Calculyator> CREATOR = new Creator<Calculyator>() {
        @Override
        public Calculyator createFromParcel(Parcel in) {
            return new Calculyator(in);
        }

        @Override
        public Calculyator[] newArray(int size) {
            return new Calculyator[size];
        }
    };
    private final int MAX_QUANTITY_AFTER_COMMA = 15;
    //Хранение больших чисел
    private final char EPTY_CHAR = Character.MIN_VALUE;
    private final char PLUS = '+';
    private final char MINUS = '-';
    private final char UMN = '*';
    private final char DIV = '/';
    private double result;
    private double firstNumber;
    private char sign;
    private boolean commaAdded;
    private boolean equalPressed;
    private int quantitAfterComma;//количество знаков после запятой

    public Calculyator() {
        this.firstNumber = 0.0;
        this.result = 0.0;
        this.commaAdded = false;
        this.quantitAfterComma = 0;
        setEqualPressed(false);
//        clearSing();

    }


    protected Calculyator(Parcel in) {
        result = in.readDouble();
        firstNumber = in.readDouble();
        sign = (char) in.readInt();
        commaAdded = in.readByte() == 0;
        equalPressed = in.readByte() == 0;
        quantitAfterComma = in.readInt();
    }

    //Устанавливает значение переменной equalPressed
    private void setEqualPressed(boolean equalPressed) {
        this.equalPressed = equalPressed;
    }

    //Обрабатывет передний знак =, выполняет вычисления
    void setEqual() {
        if (sign == EPTY_CHAR) {//Знак действия не нажат не выполняем вычисления
            return;
        }
        if (firstNumber == 0.0) {//Пользователь не ввел второе число. Дедаем вычисления с самим собой
            makeCalculyation(result, result);
        } else {
            makeCalculyation(result, firstNumber);
        }
        resetNumbers();
        clearSing();
        setEqualPressed(true);
    }

    //Очищает переменную хранящую знак
    private void clearSing() {
        this.sign = EPTY_CHAR;
    }

    //Обнуляет числа и переменные, записывает vvod в result
    private void resetNumbers() {
        result = firstNumber;
        firstNumber = 0.0;
        quantitAfterComma = 0;
        setComma(false);
    }

    //Выполняет вычисления согласно знака
    private void makeCalculyation(double vNumber, double sNumber) {
        switch (sign) {
            case PLUS:
                firstNumber = vNumber + sNumber;
                break;
            case MINUS:
                firstNumber = vNumber - sNumber;
                break;
            case DIV:
                firstNumber = vNumber / sNumber;
                break;
            case UMN:
                firstNumber = vNumber * sNumber;
                break;
        }
    }

    //Меняет знак числа
    void setChangeSing() {
        firstNumber = firstNumber * -1.0;
    }

    //Очищает все
    void cleatAll() {
        quantitAfterComma = 0;
        firstNumber = 0;
        result = 0;
        setComma(false);
        clearSing();
    }

    //Очищает последний введенный символ
    void clearOne() {
        if (quantitAfterComma == 0) {
            firstNumber = Math.floor(firstNumber / 10.0);
        } else {
            quantitAfterComma--;
            double scale = Math.pow(10, quantitAfterComma);//Множитель для дробной части
            firstNumber = Math.floor(firstNumber * scale);
            firstNumber = firstNumber / scale;
        }
    }

    //устанавливаем знак вычисления
    void setSign(String sign) {
        if (this.sign == EPTY_CHAR) {
            if (!equalPressed) {
                resetNumbers();
                setEqualPressed(false);
            }
//        } else {//Пользователь нажал знак вычисления второй раз. Выполним действия равносильные нажатию =
//
//            setEqual();
        }
        this.sign = sign.charAt(0);
    }

    //Устанавливает разделитель
    void setComma(boolean commaValue) {
        commaAdded = commaValue;
    }

    //Заполняет переданное число
    void setNumber(String number) {
        int quantityBeforComa = countNumberQuantity(Math.floor(firstNumber));
        if (quantityBeforComa >= MAX_QUANTITY_AFTER_COMMA) {
            return;
        }
        //Приводим строку к числу
        int intNumber = Integer.parseInt(number);
        if (commaAdded) {
            quantitAfterComma++;
            double scale = Math.pow(10, quantitAfterComma);
            firstNumber = firstNumber * scale;
            firstNumber = firstNumber + (double) intNumber;
            firstNumber = firstNumber / scale;
        } else {
            firstNumber = firstNumber * 10.0 + intNumber;
        }
    }

    //форматирует Result и возвращает отформатированную строку
    String getStringResult() {
        int lenght = getMinLenght(result);
        String stringFormat = String.format("%%,%df%%s", lenght);
        return String.format(stringFormat, result, sign);
    }

    //форматирует FirstNumber и возвращает отформатированную строку
    String getStringFirstNumber() {
        int lenght = getMinLenght(result);
        String stringFormat = String.format("%%,%df%%s", lenght);
        return String.format(stringFormat, firstNumber);
    }

    //Определяет колличество знаков при округлении с учетом ограничений
    private int getMinLenght(double numberToSplit) {
        int lenght = 0;
        lenght = BigDecimal.valueOf(numberToSplit).scale();
        double floordeNumber = Math.floor(numberToSplit);
        int quantituBeforComma = countNumberQuantity(floordeNumber);
        if (Math.abs(floordeNumber - numberToSplit) == 0.0) {
            lenght = 0;
        }
        return Math.min(lenght, MAX_QUANTITY_AFTER_COMMA - Math.min(MAX_QUANTITY_AFTER_COMMA, quantituBeforComma));
    }

    //Определяет колличество знаков до запятой
    private int countNumberQuantity(double vNumber) {
        int numberQuantity = 0;
        while (vNumber > 1.0) {
            vNumber /= 10.0;
            numberQuantity++;
        }
        return numberQuantity;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(result);
        dest.writeDouble(firstNumber);
        dest.writeInt((int) sign);
        dest.writeByte((byte) (commaAdded ? 1 : 0));
        dest.writeByte((byte) (equalPressed ? 1 : 0));
        dest.writeInt(quantitAfterComma);
    }

}
