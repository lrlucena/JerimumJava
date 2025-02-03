package exemplos.cataestrelas;

import java.awt.Color;
import java.util.stream.IntStream;

import org.Jogo;

enum Estado {
    INICIO, JOGANDO, FINALIZADO;
}

public class CataEstrelas extends Jogo {
    private Imagem imagemFundo;
    private Nave nave;
    private List<Estrela> estrelas;
    private Estado estado;
    private double tempo;
    private Teclado teclado;

    public CataEstrelas() {
        super("Cata Estrelas", 640, 480);
        this.nave = new Nave(this, 40, 40);
        this.estado = Estado.INICIO;
        this.teclado = new Teclado();
        this.estrelas = IntStream.range(0, 10)
            .mapToObj(i -> new Estrela(this))
            .collect(Collectors.toList());
    }

    @Override
    public void atualizar() {
        switch(estado) {
            case Estado.INICIO  -> atualizarInicio();
            case Estado.JOGANDO -> atualizarJogando();
            default             -> atualizarFinalizado();
        };
    }

    @Override
    public void desenhar() {
        imagemFundo.desenhar(0, 0, 0, falso);
        switch(estado) {
            case Estado.INICIO  -> desenharInicio();
            case Estado.JOGANDO -> desenharJogando();
            default             -> desenharFinalizado();
        };
    }

    private void atualizarInicio() {
        if (teclado.teclaPessionada(VK_I)) {
            this.estado = Estado.JOGANDO;
        };
    }

    private void desenharInicio() {
        String msg = "Pressione [I] para começar";
        fonte.desenhar(msg, this.getLargura() / 2, this.getAltura() / 2, 3, Color.YELLOW);
    }
}
