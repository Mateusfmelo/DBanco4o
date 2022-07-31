import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.util.ArrayList;
import java.util.List;


public class Database {

    private ObjectContainer database = null;

    private void abrirDB() {
        database = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "banco");
    }
    private void fecharDB(){
        database.close();
    }

    public void cadastrarCliente (Cliente cliente){
        abrirDB();
        database.store(cliente);
        System.out.println("Cliente cadastrado.");
        fecharDB();
    }
    public void cadastrarEntrega (Entrega entrega){
        abrirDB();
        database.store(entrega);
        System.out.println("Entrega cadastrada.");
        fecharDB();
    }
    public void cadastrarItemVenda (ItemVenda itemVenda){
        abrirDB();
        database.store(itemVenda);
        System.out.println("Item de venda cadastrado.");
        fecharDB();
    }
    public void cadastrarMotorista (Motorista motorista){
        abrirDB();
        database.store(motorista);
        System.out.println("Motorista cadastrado.");
        fecharDB();
    }
    public void cadastrarProduto (Produto produto){
        abrirDB();
        database.store(produto);
        System.out.println("Produto cadastrado");
        fecharDB();
    }
    public void cadastrarVeiculo (Veiculo veiculo){
        abrirDB();
        database.store(veiculo);
        System.out.println("Veiculo cadastrado.");
        fecharDB();
    }
    public void cadastrarVenda (Venda venda){
        abrirDB();
        database.store(venda);
        System.out.println("Venda cadastrada.");
        fecharDB();
    }
    public void cadastrarVendedor (Vendedor vendedor){
        abrirDB();
        database.store(vendedor);
        System.out.println("Vendedor cadastrado.");
        fecharDB();
    }
    
    public List<Cliente> exibirTodosClientes (){
        abrirDB();
        ObjectSet listCliente = database.queryByExample(Cliente.class);
        List<Cliente> cliente = new ArrayList<>();
        for (Object c: listCliente) {
            cliente.add((Cliente) c);
        }
        fecharDB();
        return cliente;
    }
   
    public void inserirCliente(Cliente cliente){
        abrirDB();
        database.store(cliente);
        fecharDB();
    }
    
    public void inserirVendedor(Vendedor vendedor){
        abrirDB();
        database.store(vendedor);
        fecharDB();
    }
    
    public void inserirVenda(Venda venda){
        abrirDB();
        database.store(venda);
        fecharDB();
    }
    
   
    public void updateVendedor(int codVdd, String ccpf, int ccomissao, String nnome, String eendereco){
        abrirDB();
        Vendedor vendedor = new Vendedor();
        vendedor.setCodVdd(codVdd);
        ObjectSet result = database.queryByExample(vendedor);
        Vendedor vendedorresult = (Vendedor) result.next();
        vendedorresult.setCpf(ccpf);
        vendedorresult.setComissao(ccomissao);
        vendedorresult.setNome(nnome);
        vendedorresult.setEndereco(eendereco);
        database.store(vendedorresult);
        fecharDB();
    }
    
    public void deletarVenda(int numVenda){
        abrirDB();
        Venda venda = new Venda();
        venda.setNumVenda(numVenda);
        ObjectSet result = database.queryByExample(Venda.class);
        Venda vendaresult = (Venda) result.next();
        database.delete(vendaresult);
        fecharDB();
    }
        
    public List<Vendedor> exibirTodosVendedores (){
        abrirDB();
        ObjectSet listVendedor = database.queryByExample(Vendedor.class);
        List<Vendedor> vendedor = new ArrayList<>();
        for (Object v: listVendedor) {
            vendedor.add((Vendedor) v);
        }
        fecharDB();
        return vendedor;
    }
    
    public List<Venda> exibirTodasVendas (){
        abrirDB();
        ObjectSet listVenda = database.queryByExample(Venda.class);
        List<Venda> venda = new ArrayList<>();
        for (Object ven: listVenda) {
            venda.add((Venda) ven);
        }
        fecharDB();
        return venda;
    }
    
    public void criarDatabase () {
        abrirDB();

        Cliente cliente = new Cliente(1, "Juliano", "5551-1499", "Bairro dos Cruzeiros", "58.123-458", "juliano@hotmail.com");
        Vendedor vendedor = new Vendedor(1, "4902322", 2, "Adrian", "Rua Tazas");
        Produto produto = new Produto(3, 80.00, "Molho especial", 81.00, "Molho");
        Venda venda = new Venda(3, 12, vendedor, cliente);
        ItemVenda itemVenda = new ItemVenda(produto, venda, 10, 1);
        Veiculo veiculo = new Veiculo("VFE-2813", 4);
        Motorista motorista = new Motorista(1, "98527496", "155321", "Juliano", "Rua dos Pássaros");
        Entrega entrega = new Entrega("18:30h", "31/02/2020", 1, venda, veiculo, motorista);

        database.store(cliente);
        database.store(vendedor);
        database.store(produto);
        database.store(venda);
        database.store(itemVenda);
        database.store(veiculo);
        database.store(motorista);
        database.store(entrega);
        System.out.println("Database criada");
        fecharDB();
    }

}
