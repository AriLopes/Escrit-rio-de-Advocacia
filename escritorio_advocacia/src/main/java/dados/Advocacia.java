package dados;


public class Advocacia {
    
    private String nomeEscritorio;
    private int numCasosAtivos;
    private double taxaHoraMedia;
    
    public Advocacia(String nomeEscritorio, int numCasosAtivos, double taxaHoraMedia) {
        this.nomeEscritorio = nomeEscritorio;
        this.numCasosAtivos = numCasosAtivos;
        this.taxaHoraMedia = taxaHoraMedia;
    }
    
    public String getNomeEscritorio() {
        return nomeEscritorio;
    }
    
    public void setNomeEscritorio(String nomeEscritorio) {
        this.nomeEscritorio = nomeEscritorio;
    }
    
    public int getNumCasosAtivos() {
        return numCasosAtivos;
    }
    
    public void setNumCasosAtivos(int numCasosAtivos) {
        this.numCasosAtivos = numCasosAtivos;
    }
    
    public double getTaxaHoraMedia() {
        return taxaHoraMedia;
    }
    
    public void setTaxaHoraMedia(double taxaHoraMedia) {
        this.taxaHoraMedia = taxaHoraMedia;
    }
    
    public double calcularHonorarios(int horasTrabalhadas) {
        return horasTrabalhadas * taxaHoraMedia;
    }
    
    public void registrarCaso(String descricaoCaso) {
        // Lógica para registrar um caso
        System.out.println("Caso registrado: " + descricaoCaso);
        numCasosAtivos++;
    }
    
    public void agendarAudiencia(String data, String hora) {
        // Lógica para agendar uma audiência
        System.out.println("Audiência agendada para " + data + " às " + hora);
    }
}
