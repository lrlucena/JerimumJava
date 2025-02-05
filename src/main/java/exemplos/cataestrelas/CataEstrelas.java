package exemplos.cataestrelas;

import java.awt.Color;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.Fonte;
import org.Imagem;
import org.Jogo;
import org.Teclado;

import static java.awt.event.KeyEvent.*;

enum Estado {
    INICIO, JOGANDO, FINALIZADO
}

public class CataEstrelas extends Jogo {
    private final Imagem imagemFundo;
    private Nave nave;
    private List<Estrela> estrelas;
    private Estado estado;
    private double tempo;
    private Teclado teclado;
    private Fonte fonte;

    public static void main(String ... args) {
        CataEstrelas cataEstrelas = new CataEstrelas();
    }

    public CataEstrelas() {
        super("Cata Estrelas", 640, 480);
        this.imagemFundo = new Imagem("fundo.png");
        this.nave = new Nave(this, 40, 40);
        this.estado = Estado.INICIO;
        this.teclado = new Teclado();
        this.fonte = new Fonte(14);
        this.estrelas = IntStream.range(0, 10)
            .mapToObj(i -> new Estrela(this))
            .collect(Collectors.toList());
    }

    @Override
    public void atualizar() {
        switch(estado) {
            case INICIO     -> atualizarInicio();
            case JOGANDO    -> atualizarJogando();
            case FINALIZADO -> atualizarFinalizado();
        }
    }

    private void atualizarFinalizado() {
    }

    private void atualizarJogando() {
    }

    @Override
    public void desenhar() {
        imagemFundo.desenhar(0, 0, 0, false);
        switch(estado) {
            case INICIO     -> desenharInicio();
            case JOGANDO    -> desenharJogando();
            case FINALIZADO -> desenharFinalizado();
        }
    }

    private void desenharFinalizado() {
    }

    private void desenharJogando() {
    }

    private void atualizarInicio() {
        if (teclado.teclaPessionada(VK_I)) {
            this.estado = Estado.JOGANDO;
        }
    }

    private void desenharInicio() {
        String msg = "Pressione [I] para começar";
        fonte.desenhar(msg, this.getLargura() / 2, this.getAltura() / 2, 3, Color.YELLOW);
    }
}
