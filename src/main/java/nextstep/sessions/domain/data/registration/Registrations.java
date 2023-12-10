package nextstep.sessions.domain.data.registration;

import java.util.ArrayList;
import java.util.List;

import nextstep.sessions.domain.exception.CannotEnrollRegistrationException;

public class Registrations {

    private final List<Registration> registrations;

    public Registrations(List<Registration> registrations) {
        this.registrations = new ArrayList<>(registrations);
    }

    public int size() {
        return registrations.size();
    }

    public void validateDuplicateEnrollment(Long userId) {
        if (isExist(userId)) {
            throw new CannotEnrollRegistrationException("이미 수강신청된 사용자 입니다.");
        }
    }

    private boolean isExist(Long userId) {
        return registrations.stream()
            .anyMatch(registration -> registration.hasUser(userId));
    }
}
