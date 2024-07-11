let buscarEstoque = document.getElementById('buscarEstoque');
let listarEstoques = document.getElementById('listarEstoques');
let res = document.getElementById('res');

buscarEstoque.addEventListener('click', () => {
    let nomeProduto = document.getElementById('nomeProduto').value;
  
    fetch(`http://localhost:8080/estoque/${nomeProduto}`)
    .then(resposta => resposta.json())
    .then(dados => {
        res.innerHTML = "<ul>"
        res.innerHTML = "<li> ID: " + dados.codEstoque;
        res.innerHTML = "<li> ID do produto: " + dados.codProduto;
        res.innerHTML += "<li> Nome do produto: " + dados.nomeProduto;
        res.innerHTML += "<li> Quantidade de produto: " + dados.quantidadeProduto;
        res.innerHTML += "</ul>"

        res.style.textAlign = "left";
        res.style.padding = "12px";
        res.style.border = "3px solid black";
        res.style.color = "rgb(240, 242, 243)";
    })
    .catch((err) => console.error("Erro ao buscar estoque!", err));
});
  
listarEstoques.addEventListener('click', ()=>{
  
    fetch(`http://localhost:8080/estoque`)
    .then(resposta => resposta.json())
    .then(dados => {
        res.innerHTML = "<ul>"
        dados.forEach(estoque => {
            res.innerHTML += "<hr>";
            res.innerHTML += "<ul>"
            res.innerHTML += "<li> ID: " + estoque.codEstoque;
            res.innerHTML += "<li> ID do produto: " + estoque.codProduto;
            res.innerHTML += "<li> Nome do produto: " + estoque.nomeProduto;
            res.innerHTML += "<li> Quantidade de produto: " + estoque.quantidadeProduto;
            res.innerHTML += "</ul>"

            res.style.textAlign = "left";
            res.style.padding = "12px";
            res.style.border = "3px solid black";
            res.style.color = "rgb(240, 242, 243)";
        })
    })
    .catch((err) => console.error("Erro ao listar estoques!", err));
});