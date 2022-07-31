import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("**************Adicionando novo cliente:***************");
        Cliente cliente2 = new Cliente(2, "Judit", "9999-9999", "Avenida Sufoco", "59.000-000", "judit@email.com");

        Database database = new Database();
        database.criarDatabase();
        database.cadastrarCliente(cliente2);

        //Adicionando cliente
        Cliente cliente3 = new Cliente(3, "Maria", "8888-7777", "Avenida dos Ganchos", "60.111-078", "maria1@email.com");

        database.cadastrarCliente(cliente3);
        List<Cliente> clienteList = database.exibirTodosClientes();
        for (Cliente c : clienteList){
           System.out.printf(String.valueOf(c));
        }
        
        System.out.println("****************Adicionando novo vendedor:*************");
        
        //Adicionando vendedor
        Vendedor vendedor1 = new Vendedor(2, "852135", 3, "Daniel", "Rua das Americas");
        
        database.cadastrarVendedor(vendedor1);
        
        List<Vendedor> vendedorList = database.exibirTodosVendedores();
        for (Vendedor v : vendedorList){
            System.out.println(String.valueOf(v));
            
        }
        System.out.println("_______________Vendedor novo adicionado____________________");
        
        System.out.println();
        System.out.println("****************Adicionando outro vendedor:*****************");
        
        //Adicionando vendedor
        Vendedor vendedor2 = new Vendedor();
        
        vendedor2.setCodVdd(3);
        vendedor2.setCpf("098.981.615-81");
        vendedor2.setComissao(4);
        vendedor2.setNome("Agamenon");
        vendedor2.setEndereco("Bairro dos trocentos");
        database.inserirVendedor(vendedor2);
        List<Vendedor> vendedorListah = database.exibirTodosVendedores();
        for (Vendedor vds : vendedorListah){
            System.out.println(vds);
        }
        System.out.println("________________VENDEDOR AGAMENON ADICIONADO____________________");
        
        System.out.println();
        System.out.println("*****************Selecionando vendedor:********************");
        
        //Selecionando vendedor
        Vendedor vendedor3 = new Vendedor();
        
        vendedor3.setCodVdd(4);
        vendedor3.setCpf("899.912.744-00");
        vendedor3.setComissao(5);
        vendedor3.setNome("Onix");
        vendedor3.setEndereco("Rua das Rosas");
        database.inserirVendedor(vendedor3);
        System.out.println();
        List<Vendedor> vendedorLista = database.exibirTodosVendedores();
        for (Vendedor vddd : vendedorLista){
            System.out.println(String.valueOf(vddd));
        }
        System.out.println("_____________________VENDEDOR ONIX SELECIONADO__________________");
        
        //Update vendedor
        System.out.println();
        System.out.println("**********************Update do vendedor:********************");
        System.out.println("**********************Com as alteracoes:*********************");
        System.out.println();
        
        int codVdd = 4;
        String ccpf = ("777.333.555-20");
        int ccomissao = (6);
        String nnome = "Mario Onix";
        String eendereco = "Rua das Bromélias";
        database.updateVendedor(codVdd, ccpf, ccomissao, nnome, eendereco);
        vendedorList = database.exibirTodosVendedores();
        for (Vendedor vdd : vendedorList){
            System.out.println(vdd);
        }
        System.out.println("______________________UPDATE DO ONIX REALIZADO____________________");
        
        //Cadastrar venda
        System.out.println();
        System.out.println("**********************Cadastrar nova venda:***********************");
        Venda venda2 = new Venda();
        
        venda2.setNumVenda(2);
        venda2.setValorTotal(50.00);
        venda2.setVendedor(vendedor1);
        venda2.setCliente(cliente2);
        database.inserirVenda(venda2);
        List<Venda> vendaList = database.exibirTodasVendas();
        for (Venda ven : vendaList){
           System.out.printf(String.valueOf(ven));
        }
        System.out.println("_______________________Cadastro venda efetuado____________________");
        
        //Cadastrar venda
        System.out.println("***********************Cadastrar nova venda:***********************");
        Venda venda3 = new Venda();
        
        venda3.setNumVenda(3);
        venda3.setValorTotal(60.00);
        venda3.setVendedor(vendedor2);
        venda3.setCliente(cliente3);
        database.inserirVenda(venda3);
        List<Venda> vendaListt = database.exibirTodasVendas();
        for (Venda vend : vendaListt){
           System.out.printf(String.valueOf(vend));
        }
        System.out.println("__________________________Cadastro NOVA venda efetuado____________________");
        
        //Deletar venda
        System.out.println();
        System.out.println();
        System.out.println("**************************Deletando venda...**********************");

        int numVenda = 3;
        database.deletarVenda(numVenda);
        vendaList = database.exibirTodasVendas();
        for (Venda ven : vendaList){
            System.out.println(ven);
            
        }
        System.out.println("___________________________Deletado____________________");
        
    }
}
