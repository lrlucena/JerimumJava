package exemplos.cataestrelas;

import java.util.Date;
import java.util.Random;
import java.awt.Color;

public class Estrela {
    private double x, y;
    private Color cor;
    private Jogo jogo;
    private List<Imagem> imagens;
    private Date data;
    
    public Estela(Jogo jogo, Color cor)  {
        this.jogo = jogo;
        this.cor = cor;
        var r = new Random();
        this.x = r.nextInt(this.jogo.getLargura());
        this.y = r.nextInt(this.jogo.getAltura());
        this.imagens = new Imagem("estrela.png").fatiar(25, 25);
        data = new Date();
    }

    public Estrela(Jogo jogo){
        this(jogo, Color.WHITE);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return this.y;
    }

    public void desenhar() {
        int indice = data.getTime() / 100 % imagens.size();
        Imagem imagem = imagens.get(indice);
        imagem.desenhe(x, y, 1);
    }

}
