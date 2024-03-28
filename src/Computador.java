import java.util.Arrays;

public class Computador {
    public String marca;
    public float preco;
    public HardwareBasico[] hwBasico;
    public SistemaOperacional os;
    public MemoriaUSB musb;
    public Cliente cliente;

    public void mostraPCConfigs() {
        System.out.println( "Computador{" +
                "marca='" + marca + '\'' +
                ", preco=" + preco +
                ", hwBasico=" + Arrays.toString(hwBasico) +
                ", os=" + os +
                ", musb=" + musb +
                ", cliente=" + cliente +
                '}');
    }

    public Computador(String marca, float preco) {
        this.marca = marca;
        this.preco = preco;
        this.hwBasico = new HardwareBasico[3];
        this.os = new SistemaOperacional();
        for (int i = 0; i < hwBasico.length; i++) {
            hwBasico[i] = new HardwareBasico();
        }
    }

    public void addMemoriaUSB(MemoriaUSB musb){

    }

    public void setHwBasico(int index, String nome, int capacidade) {
    }


}
