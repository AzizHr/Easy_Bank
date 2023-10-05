package daoImplementaion;

import dao.IPaymentDAO;
import entities.Payment;

import java.util.Optional;

public class PaymentDAOImp implements IPaymentDAO<Payment> {
    /**
     * @param payment
     * @return
     */
    @Override
    public Optional<Payment> save(Payment payment) {
        return Optional.empty();
    }
}
