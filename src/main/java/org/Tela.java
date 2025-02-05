// Classe: Tela
// Função: Cria a janela do jogo.
// Atributos:
//   canvas: Área onde os gráficos são desenhados.
//   frame: Janela principal do jogo.
// Métodos: Configura a janela e o canvas.

package org;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Tela {
    private final Dimension dim;
    public final Canvas canvas;
    public final JFrame frame;

    public Tela(String titulo, int largura, int altura) {
        dim = new Dimension(largura, altura);
        canvas = new Canvas() {
            {
                setPreferredSize(dim);
                setMaximumSize(dim);
                setMinimumSize(dim);
                setFocusable(false);
            }
        };
        frame = new JFrame(titulo) {
            {
                setIconImage(new Imagem("potigol.png").buffer);
                setSize(dim);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setResizable(false);
                setLocationRelativeTo(null);
                setVisible(true);
                add(canvas);
                pack();
            }
        };
    }
}