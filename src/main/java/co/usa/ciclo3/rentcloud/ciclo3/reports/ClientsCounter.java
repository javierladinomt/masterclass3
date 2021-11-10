package co.usa.ciclo3.rentcloud.ciclo3.reports;

import co.usa.ciclo3.rentcloud.ciclo3.model.Client;

/**
 * @author JALP
 */

public class ClientsCounter {
    private Long total;
    private Client client;

    public ClientsCounter(Long total, Client client){
        this.total = total;
        this.client = client;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
