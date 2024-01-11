package Domain.Seat;

import java.io.Serializable;

public class Seat implements Serializable {

    private int seatId;
    private int rowNumber;
    private int columnNumber;


    public Seat(int seatId, int rowNumber, int columnNumber) {
        this.seatId = seatId;
        this.rowNumber = rowNumber;
        this.columnNumber = columnNumber;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "seatId=" + seatId +
                ", rowNumber=" + rowNumber +
                ", columnNumber=" + columnNumber +
                '}';
    }

    public int getSeatId() {
        return seatId;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public int getColumnNumber() {
        return columnNumber;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public void setColumnNumber(int columnNumber) {
        this.columnNumber = columnNumber;
    }
}
