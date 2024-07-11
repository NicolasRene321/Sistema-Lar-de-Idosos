let res = document.getElementById('res')
let res_gravar = document.getElementById('res_gravar')
let gravar = document.getElementById('gravar')
let deletar = document.getElementById('listar')
let buscar = document.getElementById('buscar')

// gravar-----------------------------------------------------

gravar.addEventListener('click', ()=>{
    const codEntrega = Number(document.getElementById('codEntrega').value)
    const dataEntrega = document.getElementById('dataEntrega').value
    const nomeProdutoEntrega = document.getElementById('nomeProdutoEntrega').value
    const quantidadeEntrega = Number(document.getElementById('quantidadeEntrega').value)
    const responsavelEntrega = document.getElementById('responsavelEntrega').value
    const estoqueId = Number(document.getElementById('estoqueId').value)
    const funcionarioId = Number(document.getElementById('funcionarioId').value)

    const dados = {
        codEntrega:codEntrega,
        dataEntrega:dataEntrega,
        nomeProdutoEntrega:nomeProdutoEntrega,
        quantidadeEntrega:quantidadeEntrega,
        responsavelEntrega:responsavelEntrega,
        estoqueId:estoqueId,
        funcionarioId:funcionarioId
      
    }

    fetch('http://localhost:8080/entrega', {
        method: 'POST',
        headers: {"Content-Type":"application/json"},
        body: JSON.stringify(dados)
    })
    .then(resposta => resposta.json())
    .then(dados => {
        res.innerHTML = "Entrega feita com sucesso! <br><br>"
        res.innerHTML += "Código Entrega: " + dados.codEntrega + "<br>"
        res.innerHTML += "Data entrega: " +  dados.dataEntrega + "<br>"
        res.innerHTML += "Nome do produto: " +  dados.nomeProdutoEntrega + "<br>"
        res.innerHTML += "Quantidade entrega: " +  dados.quantidadeEntrega + "<br>"
        res.innerHTML += "Responsavel pela entrega: " +  dados.responsavelEntrega + "<br>"
        res.innerHTML += "Id do estoque: " +  dados.estoqueId + "<br>"
        res.innerHTML += "Id do Funcionário: " +  dados.funcionarioId + "<br>"
    })
    .catch((err) => console.error("Erro ao tentar cadastrar a entrega!", err))

    document.getElementById('meu-formulario').reset()
});


//listar-------------------------------------------------------------------------------------
listar.addEventListener('click', () => {
    fetch('http://localhost:8080/entrega')
        .then(resposta => resposta.json())
        .then(dados => {
            res.innerHTML = "";
            dados.forEach(dado => {
                res.innerHTML += "Código: " + dado.codEntrega + "<br>" + "Data: " + dado.dataEntrega +
                 "<br>" + "produto: " + dado.nomeProdutoEntrega + "<br>" + "quantidade: " + dado.quantidadeEntrega + "<br>" 
                 + "responsavel: " + dado.responsavelEntrega +"<br>" + "Id Estoque: " + dado.estoqueId +"<br>" + "Id funcionário: " + dado.funcionarioId + "<br>" + "<br>";
            });
        })
        .catch((err) => console.error("Falha ao listar todos os produtos", err));

    document.getElementById('meu-formulario3').reset()
});

//buscacr---------------------------------------------------------------------------
buscar.addEventListener('click', () => {
    let codEntrega = Number(document.getElementById('codEntrega').value);

    fetch(`http://localhost:8080/entrega/${codEntrega}`)
        .then(resposta => resposta.json())
        .then(dado => {
            res.innerHTML += "Código: " + dado.codEntrega + "<br>" + "Data: " + dado.dataEntrega +
                 "<br>" + "produto: " + dado.nomeProdutoEntrega + "<br>" + "quantidade: " + dado.quantidadeEntrega + "<br>" 
                 + "responsavel: " + dado.responsavelEntrega +"<br>" + "Id Estoque: " + dado.estoqueId +"<br>" + "Id funcionário: " + dado.funcionarioId + "<br>" + "<br>";
        })
        .catch((err) => console.error("Falha ao tentar encontrar a entrega!", err))
    document.getElementById('meu-formulario').reset()
});

