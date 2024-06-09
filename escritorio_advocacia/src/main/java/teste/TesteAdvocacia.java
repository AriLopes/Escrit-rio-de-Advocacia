package teste;


import dados.Advocacia;
import dados.AdvocaciaDao;

	public class TesteAdvocacia {

		 public static void main(String[] args) {
		        
		        // Criando um novo escritório de advocacia
		        Advocacia escritorio = new Advocacia("Santos e Associados", 10, 200.0);
		        
		        // Instanciando o DAO
		        AdvocaciaDao advocaciaDao = new AdvocaciaDao();
		        
		        // Cadastrar o escritório de advocacia
		        advocaciaDao.cadastrar(escritorio);
		        
		        // Consultar e exibir informações do escritório
		        Advocacia escritorioConsultado = advocaciaDao.consultar();
		        if (escritorioConsultado != null) {
		            System.out.println("Nome do Escritório: " + escritorioConsultado.getNomeEscritorio());
		            System.out.println("Número de Casos Ativos: " + escritorioConsultado.getNumCasosAtivos());
		            System.out.println("Taxa Hora Média: " + escritorioConsultado.getTaxaHoraMedia());
		        }
		        
		        // Alterar informações do escritório
		        escritorio.setTaxaHoraMedia(250.0);
		        advocaciaDao.alterar(escritorio);
		        
		        // Excluir o escritório de advocacia
		        advocaciaDao.excluir();
		    }
		

	}

	
	
