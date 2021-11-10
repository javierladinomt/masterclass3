package co.usa.ciclo3.rentcloud.ciclo3.reports;

/**
 * @author JALP
 */

public class ReservationStatus {

    private int completed;
    private int cancelled;

    public ReservationStatus(int completed, int cancelled){
        this.completed = completed;
        this.cancelled = cancelled;
    }

    public int getCompleted() {
        return completed;
    }

    public void setCompleted(int completed) {
        this.completed = completed;
    }

    public int getCancelled() {
        return cancelled;
    }

    public void setCancelled(int cancelled) {
        this.cancelled = cancelled;
    }
}
