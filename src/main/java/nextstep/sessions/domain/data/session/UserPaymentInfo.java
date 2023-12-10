package nextstep.sessions.domain.data.session;

import nextstep.payments.domain.Payment;

public class UserPaymentInfo {

    private final Long userId;
    private final Payment payment;

    public UserPaymentInfo(Long userId, Payment payment) {
        this.userId = userId;
        this.payment = payment;
    }

    public boolean hasEqualUser(Long userId) {
        return userId.equals(this.userId);
    }

    public long userId() {
        return userId;
    }

    public Payment payment() {
        return payment;
    }

}
