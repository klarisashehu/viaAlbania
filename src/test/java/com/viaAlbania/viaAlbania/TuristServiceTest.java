package com.viaAlbania.viaAlbania;

import com.viaAlbania.viaAlbania.entity.Perdorues;
import com.viaAlbania.viaAlbania.entity.Turist;
import com.viaAlbania.viaAlbania.repository.TuristRep;
import com.viaAlbania.viaAlbania.service.PerdoruesService;
import com.viaAlbania.viaAlbania.service.TuristService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TuristServiceTest {

        @Mock
        private TuristRep turistRep;

        @Mock
        private PerdoruesService perdoruesService;

        @InjectMocks
        private TuristService turistService;

        private Turist turist;

        @BeforeEach
        void setUp() {
                turist = new Turist();
                turist.setEmail("turist@test.com");
                turist.setFjalkalimi("encodedPass");
                turist.setPreferencat("det, mal");
                turist.setBuxhetiMin(100.0);
                turist.setBuxhetiMax(500.0);
        }

        @Test
        void regjistrohu_success() {
                when(perdoruesService.regjistrohu("turist@test.com", "1234"))
                                .thenReturn(Optional.of(turist));

                Optional<Turist> result = turistService.regjitrohu("turist@test.com", "1234");

                assertTrue(result.isPresent());
                assertEquals("turist@test.com", result.get().getEmail());
        }

        @Test
        void regjistrohu_fail_notTurist() {
                Perdorues user = new Perdorues();

                when(perdoruesService.regjistrohu("user@test.com", "1234"))
                                .thenReturn(Optional.of(user));

                Optional<Turist> result = turistService.regjitrohu("user@test.com", "1234");

                assertFalse(result.isPresent());
        }

        @Test
        void regjistrohu_fail_userNotFound() {
                when(perdoruesService.regjistrohu("x@test.com", "1234"))
                                .thenReturn(Optional.empty());

                Optional<Turist> result = turistService.regjitrohu("x@test.com", "1234");

                assertFalse(result.isPresent());
        }

        @Test
        void identifikohu_success() {
                when(perdoruesService.identifikohu(any(Turist.class)))
                                .thenReturn(turist);

                Turist result = turistService.identifikohu(turist);

                assertNotNull(result);
                assertEquals("turist@test.com", result.getEmail());
        }

        @Test
        void perditesoTeDhena_success() {
                turist.setPerdoruesId(1);

                when(perdoruesService.perditesoTeDhena(eq(1), any(Turist.class)))
                                .thenReturn(turist);

                Turist result = turistService.perditesoTeDhena(turist);

                assertNotNull(result);
                assertEquals("turist@test.com", result.getEmail());
        }

        @Test
        void selektoPreferenca_success() {
                when(turistRep.save(any(Turist.class)))
                                .thenReturn(turist);

                turistService.selektoPreferenca(turist, "mal, qytet");

                assertEquals("mal, qytet", turist.getPreferencat());
                verify(turistRep, times(1)).save(turist);
        }

        @Test
        void zgjidhBuxhet_success() {
                when(turistRep.save(any(Turist.class)))
                                .thenReturn(turist);

                turistService.zgjidhBuxhet(turist, 200.0, 800.0);

                assertEquals(200.0, turist.getBuxhetiMin());
                assertEquals(800.0, turist.getBuxhetiMax());
                verify(turistRep, times(1)).save(turist);
        }
}
