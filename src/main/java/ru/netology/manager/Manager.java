package ru.netology.manager;

import ru.netology.compararor.TicketsTravelTimeComparator;
import ru.netology.repository.*;
import ru.netology.domain.*;
import java.util.Arrays;
import java.util.Comparator;

public class Manager {
    private Repository repo;

    public Manager(Repository repo) {

        this.repo = repo;
    }

    public void add(Ticket ticket) {

       repo.add(ticket);
    }





    public Ticket[] findAll(String from, String to, Comparator<Ticket> comparator) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.findAll()) {
            if (matches (ticket, from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result, comparator);
        return result;

    }

    public boolean matches(Ticket ticket, String from, String to) {
        if (ticket.getDepartureAirport().contains(from) && ticket.getAirportOfArrival().contains(to)) {
            return true;
        } else {
            return false;
        }

    }

}
