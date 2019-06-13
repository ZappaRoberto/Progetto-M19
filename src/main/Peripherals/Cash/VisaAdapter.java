package main.Peripherals.Cash;

public class VisaAdapter implements PaymentAdapter {
    @Override
    public Payment pay(Payment notPaid) {
        if ((int)(Math.random()*10) > 0){
            notPaid.setCheck(Boolean.TRUE); //9 volte su 10 il pagamento riesce
        }
        return notPaid;
    }

    @Override
    public String getName() {
        return "Visa";
    }
}