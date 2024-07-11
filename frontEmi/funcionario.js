
let res = document.getElementById('res')
let res_gravar = document.getElementById('res_gravar')
let gravar = document.getElementById('gravar')
let listar = document.getElementById('listar')
let buscar = document.getElementById('buscar')
let atualizar = document.getElementById('atualizar')
let deletar = document.getElementById('deletar')


// gravar-----------------------------------------------------

gravar.addEventListener('click', () => {
    const cargoFuncionario = document.getElementById('cargoFuncionario').value
    const cpfFuncionario = document.getElementById('cpfFuncionario').value
    const nomeFuncionario = document.getElementById('nomeFuncionario').value
    const telefoneFuncionario = document.getElementById('telefoneFuncionario').value
    const situacaoFuncionario = document.getElementById('situacaoFuncionario').value

    const dados = {
        cargoFuncionario: cargoFuncionario,
        cpfFuncionario: cpfFuncionario,
        nomeFuncionario: nomeFuncionario,
        telefoneFuncionario: telefoneFuncionario,
        situacaoFuncionario: situacaoFuncionario
    }
    
    fetch('http://localhost:8080/funcionario', {
        method: 'POST',
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(dados)
    })
        .then(resposta => resposta.json())
        .then(dados => {
            res.innerHTML = "Funcionario foi cadastrado com sucesso! <br><br>"

            res.innerHTML += "Código do funcionario: " + dados.codFuncionario + "<br>"
            res.innerHTML += "Cargo do funcionario: " + dados.cargoFuncionario + "<br>"
            res.innerHTML += "CPF do fuuncionário: " + dados.cpfFuncionario + "<br>"
            res.innerHTML += "Nome do funcionário: " + dados.nomeFuncionario + "<br>"
            res.innerHTML += "Telefone do funcionário: " + dados.telefoneFuncionario + "<br>"
            res.innerHTML += "Situação do funcionário: " + dados.situacaoFuncionario
        })
        .catch((err) => console.error("Erro ao tentar cadastrar o funcioanário!", err))

    document.getElementById('meu-formulario3').reset()
});



//listar-------------------------------------------------------------------------------------
listar.addEventListener('click', () => {
    fetch('http://localhost:8080/funcionario')
        .then(resposta => resposta.json())
        .then(dados => {
            res.innerHTML = "";
            dados.forEach(dado => {
                res.innerHTML += "Código: " + dado.codFuncionario + "<br>" + "Cargo: " + dado.cargoFuncionario +
                 "<br>" + "CPF: " + dado.cpfFuncionario + "<br>" + "Nome: " + dado.nomeFuncionario + "<br>" + "Telefone: " + dado.telefoneFuncionario +"<br>" + "Situação: " + dado.situacaoFuncionario +  "<br> <br>";
            });
        })
        .catch((err) => console.error("Falha ao listar todos os produtos", err));

    document.getElementById('meu-formulario3').reset()
});

//buscacr---------------------------------------------------------------------------
buscar.addEventListener('click', () => {
    let codFuncionario = Number(document.getElementById('codFuncionario').value);

    fetch(`http://localhost:8080/funcionario/${codFuncionario}`)
        .then(resposta => resposta.json())
        .then(dados => {
            res.innerHTML += "Código: " + dados.codFuncionario + "<br>" + "Cargo: " + dados.cargoFuncionario +
            "<br>" + "CPF: " + dados.cpfFuncionario + "<br>" + "Nome: " + dados.nomeFuncionario + "<br>" + "Telefone: " 
            + dados.telefoneFuncionario +"<br>" + "Situação: " + dados.situacaoFuncionario +  "<br> <br>"
        })
        .catch((err) => console.error("Falha ao tentar encontrar o Funcionário!", err))
    document.getElementById('meu-formulario').reset()
});

//deletar----------------------------------------------------------------------------


deletar.addEventListener('click', () => {
    let codFuncionario = Number(document.getElementById('codFuncionario').value)

    fetch(`http://localhost:8080/funcionario/${codFuncionario}`, {
        method: "DELETE",
        headers: { "Content-Type": "application/json" }
    })
        .then(resposta => resposta.text())
        .then(dados => {
            res.innerHTML = "funcionário apagado com sucesso!"
        })
        .catch((err) => console.error("Erro ao apagar o funcionário!", err))

});

//atualizar---------------------------------------------------------------------


atualizar.addEventListener('click', () => {
    const codFuncionario = Number(document.getElementById('codFuncionario').value)
    const cargoFuncionario = document.getElementById('cargoFuncionario').value
    const cpfFuncionario = document.getElementById('cpfFuncionario').value
    const nomeFuncionario = document.getElementById('nomeFuncionario').value
    const telefoneFuncionario = document.getElementById('telefoneFuncionario').value
    const situacaoFuncionario = document.getElementById('situacaoFuncionario').value


    const dados = {
        cargoFuncionario: cargoFuncionario,
        cpfFuncionario: cpfFuncionario,
        nomeFuncionario: nomeFuncionario,
        telefoneFuncionario: telefoneFuncionario,
        situacaoFuncionario: situacaoFuncionario
    }

    fetch(`http://localhost:8080/funcionario/${codFuncionario}`, {
        method: "PUT",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(dados)
    })
        .then(resposta => resposta.json())
        .then(dados => {
            res.innerHTML = "Funcionário atualizado com sucesso!";
        })
        .catch((err) => console.error("Falha ao atualizar o Funcionário", err))
});