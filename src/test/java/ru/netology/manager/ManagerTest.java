package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

import ru.netology.compararor.TicketsTravelTimeComparator;
import ru.netology.repository.Repository;
import ru.netology.domain.Ticket;

import java.util.Comparator;

public class ManagerTest {

    Repository repo = Mockito.mock(Repository.class);
    Manager manager = new Manager(repo);
    TicketsTravelTimeComparator travelTimeComparator = new TicketsTravelTimeComparator();

    Ticket ticket1 = new Ticket(1, 300, "WRO", "WAW", 232);
    Ticket ticket2 = new Ticket(2, 600, "WRO", "ZAG", 10);
    Ticket ticket3 = new Ticket(3, 442, "LIS", "IEV", 123);
    Ticket ticket4 = new Ticket(4, 575, "WRO", "ZAG", 90);
    Ticket ticket5 = new Ticket(5, 314, "WRO", "ZAG", 68);
    Ticket ticket6 = new Ticket(6, 113, "WRO", "ZAG", 100);
    Ticket ticket7 = new Ticket(7, 123, "WRO", "ZAG", 110);
    Ticket ticket8 = new Ticket(8, 445, "KTW", "ODS", 112);
    Ticket ticket9 = new Ticket(9, 300, "WRO", "ZAG", 322);
    Ticket ticket10 = new Ticket(10, 300, "WRO", "ZAG", 322);


    @Test

    public void findAllSort() {
        Ticket[] tickets = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7, ticket8};
        doReturn(tickets).when(repo).findAll();


        Ticket[] excepted = {ticket2, ticket5, ticket4, ticket6, ticket7};
        Ticket[] actual = manager.findAll("WRO", "ZAG", travelTimeComparator);

        Assertions.assertArrayEquals(excepted, actual);


    }


    @Test
    public void sortingEqualElements() {

        Ticket[] tickets = {ticket9, ticket10};
        doReturn(tickets).when(repo).findAll();


        Ticket[] expected = {ticket9, ticket10};
        Ticket[] actual = manager.findAll("WRO", "ZAG",travelTimeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortingEqualElements1() {

        Ticket[] tickets = {ticket6, ticket7};
        doReturn(tickets).when(repo).findAll();


        Ticket[] expected = {ticket6, ticket7};
        Ticket[] actual = manager.findAll("WRO", "ZAG",travelTimeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void sortingEqualElements2() {

        Ticket[] tickets = {ticket7, ticket6};
        doReturn(tickets).when(repo).findAll();


        Ticket[] expected = {ticket6, ticket7};
        Ticket[] actual = manager.findAll("WRO", "ZAG",travelTimeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }



}