package com.viaAlbania.viaAlbania;

import com.viaAlbania.viaAlbania.entity.Itinerar;
import com.viaAlbania.viaAlbania.entity.Turist;
import com.viaAlbania.viaAlbania.repository.ItinerarRep;
import com.viaAlbania.viaAlbania.service.ItinerarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ItinerarServiceTest {

    @Mock
    private ItinerarRep itinerarRep;

    @InjectMocks
    private ItinerarService itinerarService;

    private Turist turist;
    private Itinerar itinerar;

    @BeforeEach
    void setUp() {
        turist = new Turist();
        turist.setPerdoruesId(1);
        turist.setEmer("Test");
        turist.setMbiemer("Turist");

        itinerar = new Itinerar();
        itinerar.setTurist(turist);
        itinerar.setKostoTotale(100.0);
        itinerar.setRaportPermbledhes("Raport Test");
    }

    @Test
    void ruajItinerar_success() {
        when(itinerarRep.save(any(Itinerar.class))).thenAnswer(i -> i.getArgument(0));

        Itinerar saved = itinerarService.ruajItinerar(itinerar);

        assertNotNull(saved.getDataGjenerimit());
        assertEquals(100.0, saved.getKostoTotale());
        verify(itinerarRep, times(1)).save(itinerar);
    }

    @Test
    void gjeneroItinerar_success() {
        LocalDate start = LocalDate.of(2026, 1, 10);
        LocalDate end = LocalDate.of(2026, 1, 15);

        when(itinerarRep.save(any(Itinerar.class))).thenAnswer(i -> i.getArgument(0));

        Itinerar result = itinerarService.gjeneroItinerar(turist, start, end, 250.0, "Raport Gjeneruar");

        assertEquals(turist, result.getTurist());
        assertEquals(start, result.getDataFillimi());
        assertEquals(end, result.getDataMbarimi());
        assertEquals(250.0, result.getKostoTotale());
        assertEquals("Raport Gjeneruar", result.getRaportPermbledhes());
        assertNotNull(result.getDataGjenerimit());
        verify(itinerarRep, times(1)).save(result);
    }

    @Test
    void merrTeGjitha_success() {
        List<Itinerar> list = new ArrayList<>();
        list.add(itinerar);
        when(itinerarRep.findAll()).thenReturn(list);

        List<Itinerar> result = itinerarService.merrTeGjitha();

        assertEquals(1, result.size());
        assertEquals(itinerar, result.get(0));
        verify(itinerarRep, times(1)).findAll();
    }

    @Test
    void merrSipasTuristi_success() {
        List<Itinerar> list = new ArrayList<>();
        list.add(itinerar);
        when(itinerarRep.findByTurist_TuristId(1)).thenReturn(list);

        List<Itinerar> result = itinerarService.merrSipasTuristi(1);

        assertEquals(1, result.size());
        assertEquals(itinerar, result.get(0));
        verify(itinerarRep, times(1)).findByTurist_TuristId(1);
    }

    @Test
    void merrMeId_found() {
        when(itinerarRep.findById(1)).thenReturn(Optional.of(itinerar));

        Optional<Itinerar> result = itinerarService.merrMeId(1);

        assertTrue(result.isPresent());
        assertEquals(itinerar, result.get());
        verify(itinerarRep, times(1)).findById(1);
    }

    @Test
    void merrMeId_notFound() {
        when(itinerarRep.findById(99)).thenReturn(Optional.empty());

        Optional<Itinerar> result = itinerarService.merrMeId(99);

        assertFalse(result.isPresent());
        verify(itinerarRep, times(1)).findById(99);
    }
}