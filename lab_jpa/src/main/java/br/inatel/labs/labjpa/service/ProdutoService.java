package br.inatel.labs.labjpa.service;

import br.inatel.labs.labjpa.entity.Produto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class ProdutoService {

    @PersistenceContext
    private EntityManager em;

    public Produto salvar(Produto p) {
        p = em.merge(p);
        return p;
    }

    public Produto buscarPeloId(Long id) {
        Produto p = em.find(Produto.class, id);
        return p;
    }

    public List<Produto> listar() {
        List<Produto> listaProduto = em.createQuery("select p from Produto p", Produto.class)
                .getResultList();
        return listaProduto;
    }

    public void remover(Produto p) {
        p = em.merge(p);
        em.remove(p);
    }
}
