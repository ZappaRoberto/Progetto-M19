package main.Manager.Subscriptions;

import main.Manager.Manager;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class MonthlySubscription extends Subscription
{
    public MonthlySubscription(Double cost)
    {
        this.cost = cost;
    }

    public GregorianCalendar makesub()
    {
        GregorianCalendar d = new GregorianCalendar();
        d.add(Calendar.MONTH, 1);
        return d;
    }
}