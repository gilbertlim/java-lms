package nextstep.sessions.domain.data.registration;

import java.util.List;

import nextstep.payments.domain.Payment;
import nextstep.sessions.domain.exception.CannotEnrollRegistrationException;
import nextstep.users.domain.NsUserTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RegistrationsTest {

    @Test
    void 단순_size_메서드_테스트() {
        Registrations registrations = new Registrations(List.of(
            new Registration(1L, 2L, new Payment()),
            new Registration(1L, 2L, new Payment())
        ));

        assertThat(registrations.size()).isEqualTo(2);
    }

    @Test
    void 이미_수강_신청된_유저() {
        Registrations registrations = new Registrations(List.of(
            new Registration(1L, 1L, new Payment()),
            new Registration(1L, 2L, new Payment())
        ));

        assertThatThrownBy(() -> registrations.validateDuplicateEnrollment(NsUserTest.JAVAJIGI.getId()))
            .isInstanceOf(CannotEnrollRegistrationException.class)
            .hasMessage("이미 수강신청된 사용자 입니다.");
    }

}
