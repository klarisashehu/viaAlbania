package com.viaAlbania.viaAlbania;

import com.viaAlbania.viaAlbania.entity.Biznes;
import com.viaAlbania.viaAlbania.entity.LinkJashtem;
import com.viaAlbania.viaAlbania.repository.LinkJashtemRep;
import com.viaAlbania.viaAlbania.service.LinkJashtemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LinkJashtemServiceTest {

    @Mock
    private LinkJashtemRep rep;

    @InjectMocks
    private LinkJashtemService service;

    private LinkJashtem link;
    private Biznes biznes;

    @BeforeEach
    void setUp() {
        biznes = new Biznes();
        biznes.setBiznesId(1);

        link = new LinkJashtem();
        link.setLinkJashtemId(1);
        link.setLink("https://example.com");
        link.setTipi("Website");
        link.setBiznes(biznes);
    }

    @Test
    void shtoLink_success() {
        when(rep.save(any(LinkJashtem.class))).thenAnswer(i -> i.getArgument(0));

        LinkJashtem result = service.shtoLink(link);

        assertNotNull(result);
        assertEquals("Website", result.getTipi());
        assertEquals("https://example.com", result.getLink());
        assertEquals(1, result.getBiznes().getBiznesId());
    }

    @Test
    void perditesoLink_success() {
        LinkJashtem updated = new LinkJashtem();
        updated.setTipi("Instagram");
        updated.setLink("https://instagram.com");
        updated.setBiznes(biznes);

        when(rep.findById(1)).thenReturn(Optional.of(link));
        when(rep.save(any(LinkJashtem.class))).thenAnswer(i -> i.getArgument(0));

        LinkJashtem result = service.perditesoLink(1, updated);

        assertNotNull(result);
        assertEquals("Instagram", result.getTipi());
        assertEquals("https://instagram.com", result.getLink());
    }

    @Test
    void perditesoLink_notFound() {
        when(rep.findById(99)).thenReturn(Optional.empty());

        LinkJashtem result = service.perditesoLink(99, link);

        assertNull(result);
    }

    @Test
    void fshiLink_success() {
        when(rep.findById(1)).thenReturn(Optional.of(link));

        boolean result = service.fshiLink(1);

        assertTrue(result);
        verify(rep).deleteById(1);
    }

    @Test
    void fshiLink_notFound() {
        when(rep.findById(99)).thenReturn(Optional.empty());

        boolean result = service.fshiLink(99);

        assertFalse(result);
    }

    @Test
    void merrTeGjithaSipasBiznesit_success() {
        List<LinkJashtem> list = new ArrayList<>();
        list.add(link);

        when(rep.findByBiznes_BiznesId(1)).thenReturn(list);

        List<LinkJashtem> result = service.merrTeGjithaSipasBiznesit(1);

        assertEquals(1, result.size());
        assertEquals("Website", result.get(0).getTipi());
    }

    @Test
    void merrMeId_success() {
        when(rep.findById(1)).thenReturn(Optional.of(link));

        Optional<LinkJashtem> result = service.merrMeId(1);

        assertTrue(result.isPresent());
        assertEquals("Website", result.get().getTipi());
    }

    @Test
    void merrMeId_notFound() {
        when(rep.findById(99)).thenReturn(Optional.empty());

        Optional<LinkJashtem> result = service.merrMeId(99);

        assertFalse(result.isPresent());
    }
}