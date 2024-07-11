let res = document.getElementById('res')
let res_gravar = document.getElementById('res_gravar')
let gravar = document.getElementById('gravar')
let listar = document.getElementById('listar')
let buscar = document.getElementById('buscar')
let deletar = document.getElementById('deletar')


// gravar-----------------------------------------------------

gravar.addEventListener('click', ()=>{
    let codFuncionario = Number(document.getElementById('codFuncionario').value)
    let nomeFabricante = document.getElementById('nomeFabricante').value


    const dados = {
        nomeFabricante: nomeFabricante,
        codFuncionario: codFuncionario
    }

    fetch('http://localhost:8080/fabricante', {
        method: 'POST',
        headers: {"Content-Type":"application/json"},
        body: JSON.stringify(dados)
    })
    .then(resposta => resposta.json())
    .then(dados => {
        res.innerHTML = "Fabricante cadastrado com sucesso! <br><br>"
        res.innerHTML += "Código do Funcionário: " +  dados.codFuncionario + "<br>"
        res.innerHTML += "Nome do Fabricante: " +  dados.nomeFabricante + "<br>"
        res.innerHTML += "Código Fabricante: " + dados.codFabricante + "<br>"
    })
    .catch((err) => console.error("Erro ao tentar cadastrar o fabricante!", err))

    document.getElementById('meu-formulario').reset()
});

//listar------------------------------------------------------------------------

listar.addEventListener('click', ()=>{
    fetch('http://localhost:8080/fabricante')
    .then(resposta => resposta.json())
    .then(dados => {
        res.innerHTML = "";
        dados.forEach(dado => {
            res.innerHTML += "Código: " + dado.codFabricante + "<br>" + "Nome: " + dado.nomeFabricante + "<br>" ; 
        }); 
    })
    .catch((err) => console.error("Falha ao listar todos os fabricantes", err))
    
    document.getElementById('meu-formulario').reset()
});

//buscar------------------------------------------------------------------------

buscar.addEventListener('click', ()=>{
    let codFabricante = Number(document.getElementById('codFabricante').value);

    fetch(`http://localhost:8080/fabricante/${codFabricante}`)
    .then(resposta => resposta.json())
    .then(dado => {
        res.innerHTML += "Código: " + dado.codFabricante + "<br>" + "Nome: " + dado.nomeFabricante + "<br>" 
    })
    .catch((err) => console.error("Falha ao tentar encontrar o Fabricante!", err))
    
    document.getElementById('meu-formulario').reset()
});

//deletar-------------------------------------------------------------------------

deletar.addEventListener('click', () => {
    let codFabricante =Number(document.getElementById('codFabricante').value)

    fetch(`http://localhost:8080/fabricante/${codFabricante}`, {
        method: "DELETE",
        headers: { "Content-Type": "application/json" }
    })
        .then(resposta => resposta.text())
        .then(dados => {
            res.innerHTML = "Fabricante apagado com sucesso!"
        })
        .catch((err) => console.error("Erro ao apagar o Fabricante!", err))

});
//atualizar--------------------------------------------------------------------
atualizar.addEventListener('click', () => {
    let codFabricante = Number(document.getElementById('codFabricante').value)
    let nomeFabricante = document.getElementById('nomeFabricante').value
    let codFuncionario = Number(document.getElementById('codFuncionario').value)




    const dados = {

        nomeFabricante: nomeFabricante,
        codFuncionario:codFuncionario
   
    }

    fetch(`http://localhost:8080/fabricante/${codFabricante}`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(dados)
    })
        .then(resposta => resposta.json())
        .then(dados => {
            res.innerHTML = "Fabricante atualizado com sucesso!";
        })
        .catch((err) => console.error("Falha ao atualizar o Fabricante", err))
});