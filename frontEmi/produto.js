
let res = document.getElementById('res')
let res_gravar = document.getElementById('res_gravar')
let gravar = document.getElementById('gravar')
let listar = document.getElementById('listar')


// gravar-----------------------------------------------------

gravar.addEventListener('click', ()=>{
    let nomeProduto = document.getElementById('nomeProduto').value
    let quantidadeProduto = Number(document.getElementById('quantidadeProduto').value)
    let valorProduto = Number(document.getElementById('valorProduto').value)
    let descricaoProduto = document.getElementById('descricaoProduto').value
    let validadeProduto = document.getElementById('validadeProduto').value
    let doadorId = Number(document.getElementById('doadorId').value)
    let estoqueId = Number(document.getElementById('estoqueId').value)
    let fabricanteId = Number(document.getElementById('fabricanteId').value)
    let funcionarioId = Number(document.getElementById('funcionarioId').value)
    
    const dados = {
    
        nomeProduto: nomeProduto,
        quantidadeProduto: quantidadeProduto,
        descricaoProduto: descricaoProduto,
        validadeProduto: validadeProduto,
        doadorId: doadorId,
        estoqueId, estoqueId,
        fabricanteId: fabricanteId,
        funcionarioId: funcionarioId,
        valorProduto: valorProduto
    }


    fetch('http://localhost:8080/produto', {
        method: 'POST',
        headers: {"Content-Type":"application/json"},
        body: JSON.stringify(dados)
    })
    .then(resposta => resposta.json())
    .then(dados => {
        res.innerHTML = "Produto cadastrado com sucesso! <br><br>"
        res.innerHTML += "Código: " + dados.codProduto + "<br>"
        res.innerHTML += "Nome: " +  dados.nomeProduto + "<br>"
        res.innerHTML += "Quantidade: " +  dados.quantidadeProduto + "<br>"
        res.innerHTML += "Descrição: " +  dados.descricaoProduto + "<br>"
        res.innerHTML += "Validade: " +  dados.validadeProduto + "<br>"
        res.innerHTML += "Valor: " +  dados.valorProduto + "<br>"
        res.innerHTML += "Doador ID: " +  dados.doadorId + "<br>"
        res.innerHTML += "Estoque ID: " +  dados.estoqueId + "<br>"
        res.innerHTML += "Fabricante ID: " +  dados.fabricanteId + "<br>"
        res.innerHTML += "Funcionário ID: " +  dados.funcionarioId + "<br>"
    })
    .catch((err) => console.error("Erro ao tentar cadastrar produto!", err))
});


//listar-------------------------------------------------------------------------------------
listar.addEventListener('click', () => {
    fetch('http://localhost:8080/produto')
        .then(resposta => resposta.json())
        .then(dados => {
            res.innerHTML = "";
            dados.forEach(dado => {
                res.innerHTML = "Código: " + dado.codProduto + "<br>"
                 + "Nome: " +  dado.nomeProduto + "<br>"
                 + "Quantidade: " +  dado.quantidadeProduto + "<br>"
                 + "Descrição: " +  dado.descricaoProduto + "<br>"
                 + "Validade: " +  dado.validadeProduto + "<br>"
                 + "Valor: " +  dado.valorProduto + "<br>"
                 + "Doador ID: " +  dado.doadorId + "<br>"
                 + "Estoque ID: " +  dado.estoqueId + "<br>"
                 + "Fabricante ID: " +  dado.fabricanteId + "<br>"
                 + "Funcionário ID: " +  dado.funcionarioId + "<br>"});
        })
        .catch((err) => console.error("Falha ao listar todos os produtos", err));

    document.getElementById('meu-formulario3').reset()
});

