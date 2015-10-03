package com.ginvaell.module2.task1;

/**
 * Created by ginva_000 on 02.10.2015.
 */
public class Pen {
    private final String name;
    private final String manufacturer;
    private double thickness;
    private double prise;

    public Pen(String name, String manufacturer) {
        this.name = name;
        this.manufacturer = manufacturer;
    }

    public double getThickness() {
        return thickness;
    }

    public void setThickness(double thickness) {
        this.thickness = thickness;
    }

    public double getPrise() {
        return prise;
    }

    public void setPrise(double prise) {
        this.prise = prise;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) return true;
        if (!(o instanceof Pen)) return false;

        Pen pen = (Pen) o;

        if (Double.compare(pen.getThickness(), getThickness()) != 0) return false;
        if (Double.compare(pen.getPrise(), getPrise()) != 0) return false;
        if (!getName().equals(pen.getName())) return false;
        return getManufacturer().equals(pen.getManufacturer());

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getName().hashCode();
        result = 31 * result + getManufacturer().hashCode();
        temp = Double.doubleToLongBits(getThickness());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getPrise());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Pen{" +
                "name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", thickness=" + thickness +
                ", prise=" + prise +
                '}';
    }
}
