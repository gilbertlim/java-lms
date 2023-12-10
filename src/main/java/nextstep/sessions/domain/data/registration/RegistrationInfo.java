package nextstep.sessions.domain.data.registration;

import nextstep.payments.domain.Payment;
import nextstep.sessions.domain.data.session.UserPaymentInfo;

public class RegistrationInfo {

    private final Long sessionId;
    private final UserPaymentInfo userPaymentInfo;

    public RegistrationInfo(Long sessionId, UserPaymentInfo userPaymentInfo) {
        this.sessionId = sessionId;
        this.userPaymentInfo = userPaymentInfo;
    }

    public long userId() {
        return userPaymentInfo.userId();
    }

    public long paymentId() {
        return userPaymentInfo.payment().getId();
    }

    public Payment payment() {
        return userPaymentInfo.payment();
    }

    public boolean hasEqualUser(Long userId) {
        return userPaymentInfo.hasEqualUser(userId);
    }

    public Long sessionId() {
        return sessionId;
    }

}
