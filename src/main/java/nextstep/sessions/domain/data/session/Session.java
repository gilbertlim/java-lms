package nextstep.sessions.domain.data.session;

import java.time.LocalDateTime;
import java.util.List;

import nextstep.sessions.domain.data.registration.Registration;

public class Session {

    private Long id;
    private final Enrollment enrollment;
    private OpenInfo openInfo;

    public Session(Enrollment enrollment) {
        this.enrollment = enrollment;
    }

    public Session(
        Long id,
        PaidType paidType,
        Long fee,
        int capacity,
        SessionRunningState sessionRunningStateState,
        SessionRecruitingState sessionRecruitingState,
        LocalDateTime startDate,
        LocalDateTime endDate
    ) {
        this(id,
            new Enrollment(
                new SessionType(paidType, fee, capacity),
                new SessionState(sessionRunningStateState, sessionRecruitingState)),
            new OpenInfo(new Duration(startDate, endDate)));
    }

    public Session(Enrollment enrollment, OpenInfo openInfo) {
        this.enrollment = enrollment;
        this.openInfo = openInfo;
    }

    public Session(Long id, Enrollment enrollment, OpenInfo openInfo) {
        this.id = id;
        this.enrollment = enrollment;
        this.openInfo = openInfo;
    }

    public Enrollment enrollment(List<Registration> registrations) {
        return new Enrollment(registrations);
    }

    public String paidType() {
        return enrollment.paidType();
    }

    public long fee() {
        return enrollment.fee();
    }

    public int capacity() {
        return enrollment.capacity();
    }

    public String sessionRunningState() {
        return enrollment.sessionRunningState();
    }

    public String sessionRecruitingState() {
        return enrollment.sessionRecruitingState();
    }

    public LocalDateTime startDate() {
        return openInfo.startDate();
    }

    public LocalDateTime endDate() {
        return openInfo.endDate();
    }

    public Long sessionId() {
        return id;
    }
}
