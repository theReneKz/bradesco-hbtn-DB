package demo;

import entities.Pessoa;
import entities.Produto;
import models.PessoaModel;
import models.ProdutoModel;

import java.util.Date;
import java.util.List;

public class AdministrativoApp {
    public static void main(String[] args) {
        ProdutoModel produtoModel = new ProdutoModel();
        PessoaModel pessoaModel = new PessoaModel();

        Produto p1 = new Produto();
        p1.setNome("TV");
        p1.setPreco(300.0);
        p1.setQuantidade(100);
        p1.setStatus(true);
        // 1) Criando um produto
        produtoModel.create(p1);
        //2) Buscando todos os produtos na base de dados
        List<Produto> produtos = produtoModel.findAll();
        System.out.println("Qtde de produtos encontrados : " + produtos.size());
        Produto produto = produtoModel.findById((produtos.getFirst()));
        System.out.println("Produto encontrado com sucesso: " + produto.toString());
        produtoModel.update(produto);
        System.out.println("Produto atualizado com sucesso: " + produto.toString());
        produtoModel.delete(produto);
        System.out.println("Produto deletado com sucesso ");


        

        Pessoa pessoa1 = new Pessoa();
        pessoa1.setCpf("04403971656");
        pessoa1.setNome("Fulano de Tal");
        pessoa1.setDataNascimento(new Date());
        pessoa1.setIdade(22);
        pessoa1.setEmail("user@mail.com");
        pessoaModel.create(pessoa1);
        List<Pessoa> pessoas = pessoaModel.findAll();
        System.out.println("Qtde de pessoas encontradas : " + pessoas.size());
        Pessoa pessoa = pessoaModel.findById(pessoas.getFirst());
        System.out.println("Pessoa encontrada com sucesso: " + pessoa.toString());
        pessoaModel.update(pessoa);
        System.out.println("Pessoa atualizada com sucesso: " + pessoa.toString());
        pessoaModel.delete(pessoa);
        System.out.println("Pessoa deletada com sucesso ");

         
    }
}

