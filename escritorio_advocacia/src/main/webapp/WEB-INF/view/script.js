document.getElementById("formAdvocacia").addEventListener("submit", function(event) {
    event.preventDefault();

    let nomeEscritorio = document.getElementById("nomeEscritorio").value;
    let numCasosAtivos = document.getElementById("numCasosAtivos").value;
    let taxaHoraMedia = document.getElementById("taxaHoraMedia").value;

    localStorage.setItem("nomeEscritorio", nomeEscritorio);
    localStorage.setItem("numCasosAtivos", numCasosAtivos);
    localStorage.setItem("taxaHoraMedia", taxaHoraMedia);

    showMessage("Escritório registrado com sucesso!", true);
});

function registrarCaso() {
    let numCasosAtivos = parseInt(localStorage.getItem("numCasosAtivos"));
    numCasosAtivos++;
    localStorage.setItem("numCasosAtivos", numCasosAtivos);
    showMessage("Caso registrado com sucesso! Casos Ativos: " + numCasosAtivos, true);
}

function agendarAudiencia() {
    let data = prompt("Digite a data da audiência (dd/mm/yyyy):");
    let hora = prompt("Digite a hora da audiência (HH:MM):");
    showMessage("Audiência agendada para " + data + " às " + hora, true);
}

function calcularHonorarios() {
    let horasTrabalhadas = parseFloat(prompt("Digite o número de horas trabalhadas:"));
    let taxaHoraMedia = parseFloat(localStorage.getItem("taxaHoraMedia"));
    let honorarios = horasTrabalhadas * taxaHoraMedia;
    showMessage("Honorários calculados: R$" + honorarios.toFixed(2), true);
}

function showMessage(message, success) {
    let messageBox = document.getElementById("messages");
    messageBox.innerHTML = message;
    messageBox.className = success ? "success-message" : "error-message";
}
