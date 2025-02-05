package exemplos.cataestrelas;

import org.Imagem;
import org.Jogo;
import org.Util;

import java.util.List;
import java.util.stream.Collectors;

public class Nave {
    private final Jogo jogo;
    private double x, y;
    private final Imagem imagem;
    private int pontos;
    private double velX, velY;
    private double angulo;
    private final double camada;

    public Nave(Jogo jogo, double x, double y){
        this.jogo = jogo;
        this.x = x;
        this.y = y;
        this.imagem = new Imagem("nave.png");
        this.camada = 3;
    }

    public void desenhar() {
        imagem.desenhar(this.x, this.y, this.camada, this.angulo);
    }

    public void girarDireita() {
        this.angulo += 5;
    }

    public void girarEsquerda() {
        this.angulo -= 5;
    }

    public void acelerar() {
        this.velX += 0.5 * Util.projecaoX(angulo);
        this.velY += 0.5 * Util.projecaoY(angulo);
    }

    public void mover() {
        this.x = (this.x + this.velX + jogo.getLargura()) % jogo.getLargura();
        this.y = (this.y + this.velY + jogo.getAltura()) % jogo.getAltura();
        this.velX *= 0.95;
        this.velY *= 0.95;
    }

    public List<Estrela> catarEstrelas(List<Estrela> estrelas) {
        var estrelasLonge = estrelas.stream().filter(
            estrela -> Util.distancia(this.x, this.y, estrela.getX(), estrela.getY()) >= 35
        ).collect(Collectors.toList());
        this.pontos += 10 * (estrelas.size() - estrelasLonge.size());
        return estrelasLonge;
    }

    public int getPontos() {
        return pontos;
    }
}
