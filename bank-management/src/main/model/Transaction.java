package src.main.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Transaction implements Comparable<Transaction> {
    public enum Type {
        DEPOSIT, WITHDRAW
    }
    private Type type;
    private String id;
    private double amount;
    private long timestamp;

    public Transaction(Type type, long timestamp, String id, double amount) {
        if(id == null || id.isBlank() || amount < 0) {
            throw new IllegalArgumentException("INVALID PARAMETERS");
        }
        this.type = type;
        this.id = id;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public Transaction(Transaction source) {
        this.type = source.type;
        this.id = source.id;
        this.amount = source.amount;
        this.timestamp = source.timestamp;
    }

    public Type getType() {
        return this.type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        if(id == null || id.isBlank()) {
            throw new IllegalArgumentException("INVALID PARAMETERS");
        }
        this.id = id;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        if(amount  < 0) {
            throw new IllegalArgumentException("INVALID PARAMTERS");
        }
        this.amount = amount;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String returnDate() {
        Date date = new Date(this.timestamp * 1000);
        return new SimpleDateFormat("dd-MM-yyyy").format(date);
    }

    @Override
    public int compareTo(Transaction o) {
        return Double.compare(this.timestamp, o.timestamp);
    }

    @Override
    public String toString() {
        return (type) + "    " +
            "\t" + this.returnDate() + "" +
            "\t" + this.id + "" +
            "\t$" + this.amount + "";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Transaction)) {
            return false;
        }
        Transaction transaction = (Transaction) o;
        return Objects.equals(type, transaction.type) && Objects.equals(id, transaction.id) && amount == transaction.amount && timestamp == transaction.timestamp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, id, amount, timestamp);
    }

}
