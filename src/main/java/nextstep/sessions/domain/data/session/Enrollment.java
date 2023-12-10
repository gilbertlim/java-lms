package nextstep.sessions.domain.data.session;

import java.util.List;

import nextstep.payments.domain.Payment;
import nextstep.sessions.domain.data.registration.Registration;
import nextstep.sessions.domain.data.registration.Registrations;

public class Enrollment {

    private EnrollmentInfo enrollmentInfo;
    private Registrations registrations;

    public Enrollment(SessionType sessionType, SessionState sessionState) {
        this.enrollmentInfo = new EnrollmentInfo(sessionType, sessionState);
    }

    public Enrollment(List<Registration> registrations) {
        this.registrations = new Registrations(registrations);
    }

    public Enrollment(EnrollmentInfo enrollmentInfo, Registrations registrations) {
        this.enrollmentInfo = enrollmentInfo;
        this.registrations = registrations;
    }

    public void enroll(Registration registration) {
        enrollmentInfo.validateEnrollment(registrations.size(), registration.payment());
        registrations.validateDuplicateEnrollment(registration.userId());
    }

    public Registration registration(Long sessionId, Long userId, Payment payment) {
        return new Registration(sessionId, userId, payment);
    }

    public String paidType() {
        return enrollmentInfo.paidType();
    }

    public long fee() {
        return enrollmentInfo.fee();
    }

    public int capacity() {
        return enrollmentInfo.capacity();
    }

    public String sessionRunningState() {
        return enrollmentInfo.sessionRunningState();
    }

    public String sessionRecruitingState() {
        return enrollmentInfo.sessionRecruitingState();
    }
}
