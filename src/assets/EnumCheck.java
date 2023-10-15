package assets;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author agond
 */
public class EnumCheck {
    public enum NumbersValidStatus{
        VERYSHORT,
        VERYLONG,
        HASLETTER,
        ISNULL,
        VALID;
    }
    public enum ValidStatus{
        INVALID,
        ISNULL,
        VALID;
    }
    public enum DiscountType{
        FLAT,
        PERCENT;
    }
    public enum PwdValidStatus{
        VERYSHORT,
        ISNULL,
        MISSINGNUMBER,
        MISSINGLETTER,
        UNMATCH,
        VALID;
    }
    public enum DateValidStatus{
        UNCORRECTFORMAT,
        ISNULL,
        INVALID,
        VALID;
    }
}
