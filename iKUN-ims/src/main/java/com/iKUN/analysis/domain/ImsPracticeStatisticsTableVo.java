package com.iKUN.analysis.domain;

/**
 * @Author iKUN
 * @Date 2023/1/28 11:11
 * @Description 实习人数统计tableVo
 * @Version 1.0
 */
public class ImsPracticeStatisticsTableVo {

    /** 院系名称 */
    private String deptName;
    /** 已提交、正在进行 */
    private long columnNum1;
    /** 已审核、已完成 */
    private long columnNum2;
    /** 未XX */
    private long columnNum3;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public long getColumnNum1() {
        return columnNum1;
    }

    public void setColumnNum1(long columnNum1) {
        this.columnNum1 = columnNum1;
    }

    public long getColumnNum2() {
        return columnNum2;
    }

    public void setColumnNum2(long columnNum2) {
        this.columnNum2 = columnNum2;
    }

    public long getColumnNum3() {
        return columnNum3;
    }

    public void setColumnNum3(long columnNum3) {
        this.columnNum3 = columnNum3;
    }

    @Override
    public String toString() {
        return "ImsPracticeStatisticsTableVo{" +
                "deptName='" + deptName + '\'' +
                ", columnNum1=" + columnNum1 +
                ", columnNum2=" + columnNum2 +
                ", columnNum3=" + columnNum3 +
                '}';
    }
}
