// Classe: Fonte
// Função: Gerencia a renderização de texto.
// Atributos:
//   font: Fonte utilizada para desenhar texto.
// Métodos:
//   desenhe(msg, x, y, z, cor): Desenha uma string em uma posição específica.
//   desenheCentralizado(msg, x, y, z, cor): Desenha uma string centralizada em relação a um ponto.

package org;

import java.awt.*;

public class Fonte {

    public Fonte(int tamanho) {
    }

    public void desenhar(String msg, double x, double y, int camada, Color cor) {
    }
}

class Fonte2 {
    private final Font font;

    public Fonte2(int tamanho) {
        this.font = new Font("Dialog", Font.BOLD, tamanho);
    }

    public void desenheCentralizado(String msg, double x, double y, int z, Cor cor) {
        Desenho.incluir(z, g -> {
            g.setColor(cor.color());
            g.setFont(font);
            int largura = g.getFontMetrics().stringWidth(msg);
            int altura = g.getFontMetrics().getHeight();
            g.drawString(msg, (int) x - largura / 2, (int) y - altura / 2);
        });
    }

    public void desenhe(String msg, double x, double y, int z, Cor cor) {
        Desenho.incluir(z, g -> {
            g.setColor(cor.color());
            g.setFont(font);
            g.drawString(msg, (int) x, (int) y);
        });
    }
}