package com.viaAlbania.viaAlbania;

import com.viaAlbania.viaAlbania.entity.Itinerar;
import com.viaAlbania.viaAlbania.entity.Lokacion;
import com.viaAlbania.viaAlbania.entity.PikaPerItinerar;
import com.viaAlbania.viaAlbania.entity.PikaPerItinerarId;
import com.viaAlbania.viaAlbania.repository.PikaPerItinerarRep;
import com.viaAlbania.viaAlbania.service.PikaPerItinerarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PikaPerItinerarServiceTest {

    @Mock
    private PikaPerItinerarRep rep;

    @InjectMocks
    private PikaPerItinerarService service;

    private Itinerar itinerar;
    private Lokacion lokacion;
    private PikaPerItinerar pika;
    private PikaPerItinerarId pikaId;

    @BeforeEach
    void setUp() {
        itinerar = new Itinerar();
        itinerar.setItinerarId(1);

        lokacion = new Lokacion();
        lokacion.setLokacionId(1);
        lokacion.setLatitude(41.3275);
        lokacion.setLongitude(19.8189);

        pikaId = new PikaPerItinerarId(itinerar.getItinerarId(), lokacion.getLokacionId());

        pika = new PikaPerItinerar();
        pika.setItinerar(itinerar);
        pika.setLokacion(lokacion);
        pika.setRendi(1);
        pika.setCheckin(false);
    }

    @Test
    void shtoPikeNeItinerar_success() {
        when(rep.save(any(PikaPerItinerar.class))).thenAnswer(i -> i.getArgument(0));

        PikaPerItinerar result = service.shtoPikeNeItinerar(itinerar, lokacion, 1);

        assertNotNull(result);
        assertEquals(1, result.getRendi());
        assertFalse(result.isCheckin());
    }

    @Test
    void ndryshoRend_success() {
        pika.setRendi(1);
        when(rep.findById(pikaId)).thenReturn(Optional.of(pika));
        when(rep.save(any(PikaPerItinerar.class))).thenAnswer(i -> i.getArgument(0));

        PikaPerItinerar result = service.ndryshoRend(itinerar, lokacion, 2);

        assertNotNull(result);
        assertEquals(2, result.getRendi());
    }

    @Test
    void ndryshoRend_notFound() {
        when(rep.findById(pikaId)).thenReturn(Optional.empty());

        PikaPerItinerar result = service.ndryshoRend(itinerar, lokacion, 2);

        assertNull(result);
    }

    @Test
    void bejCheckIn_success() {
        when(rep.findById(pikaId)).thenReturn(Optional.of(pika));
        when(rep.save(any(PikaPerItinerar.class))).thenAnswer(i -> i.getArgument(0));

        PikaPerItinerar result = service.bejCheckIn(itinerar, lokacion);

        assertNotNull(result);
        assertTrue(result.isCheckin());
        assertNotNull(result.getCheckinTime());
    }

    @Test
    void bejCheckIn_notFound() {
        when(rep.findById(pikaId)).thenReturn(Optional.empty());

        PikaPerItinerar result = service.bejCheckIn(itinerar, lokacion);

        assertNull(result);
    }

    @Test
    void llogaritDistancen_correct() {
        Lokacion l2 = new Lokacion();
        l2.setLatitude(41.3276);
        l2.setLongitude(19.8190);

        double distance = service.llogaritDistancen(lokacion, l2);

        assertTrue(distance > 0);
    }
}