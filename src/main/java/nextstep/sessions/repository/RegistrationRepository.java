package nextstep.sessions.repository;

import java.util.List;
import java.util.Optional;

import nextstep.sessions.domain.data.registration.Registration;

public interface RegistrationRepository {

    List<Registration> findAllById(Long sessionId);

    void save(Registration registration);

    Optional<Registration> findById(Long registrationId);

    void updateSelectionType(Registration registration);

    void updateApprovalType(Registration registration);

    void deleteById(Long registrationId);
}
