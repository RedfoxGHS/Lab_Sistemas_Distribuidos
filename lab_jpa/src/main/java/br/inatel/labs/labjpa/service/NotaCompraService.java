package br.inatel.labs.labjpa.service;

import br.inatel.labs.labjpa.entity.NotaCompra;
import br.inatel.labs.labjpa.entity.NotaCompraItem;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class NotaCompraService {


    @PersistenceContext
    private EntityManager em;

    public NotaCompra salvarNotaCompra(NotaCompra nc) {
        nc = em.merge(nc);
        return nc;
    }

    public NotaCompra buscarNotaCompraPeloId(Long id) {
        NotaCompra nc = em.find(NotaCompra.class, id);
        return nc;
    }

    public NotaCompra buscarNotaCompraPeloIdComListaItem(Long id) {
        NotaCompra nota = em.find(NotaCompra.class, id);
        nota.getListaNotaCompraItem().size(); // Provocando o Proxy para buscar a lista de itens
        return nota;
    }

    public List<NotaCompra> listaNotaCompra() {
        List<NotaCompra> notas = em.createQuery("select n from NotaCompra n", NotaCompra.class).getResultList();
        return notas;
    }

    public NotaCompraItem salvarNotaCompraItem(NotaCompraItem item) {
        item = em.merge(item);
        return item;
    }

    public NotaCompraItem buscarNotaCompraItemPeloId(Long id) {
        NotaCompraItem item = em.find(NotaCompraItem.class, id);
        return item;
    }

    public List<NotaCompraItem> listaNotaCompraItem() {
        List<NotaCompraItem> itens = em.createQuery("select i from NotaCompraItem i", NotaCompraItem.class).getResultList();
        return itens;
    }


}
