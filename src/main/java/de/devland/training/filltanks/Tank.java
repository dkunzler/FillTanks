package de.devland.training.filltanks;

public class Tank {
    private int heightLeft;
    private int heightRight;
    private int width = 1;

    public Tank(int heightLeft, int heightRight) {
        this.heightLeft = heightLeft;
        this.heightRight = heightRight;
    }

    public int getHeightLeft() {
        return heightLeft;
    }

    public void setHeightLeft(int heightLeft) {
        this.heightLeft = heightLeft;
    }

    public int getHeightRight() {
        return heightRight;
    }

    public void setHeightRight(int heightRight) {
        this.heightRight = heightRight;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getVolume() {
        return Math.min(heightLeft, heightRight) * width;
    }

    @Override
    public String toString() {
        return "[" + heightLeft + "," + heightRight + "] - " + width;
    }
}
