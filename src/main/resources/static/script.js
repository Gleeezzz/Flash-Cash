// On sélectionne le formulaire
const loginForm = document.getElementById('loginForm');

if (loginForm) {
    // 1. Écouteur d'événement (Event Listener)
    loginForm.addEventListener('submit', async (event) => {
        event.preventDefault(); // Empêche le rechargement immédiat de la page

        const email = document.getElementById('email').value;
        const password = document.getElementById('password').value;

        console.log("Tentative de connexion pour :", email);

        try {
            // 2. Fonction Asynchrone avec FETCH
            // On utilise 'await' pour attendre la réponse sans figer le navigateur
            const response = await fetch('/api/login', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ email, password })
            });

            if (response.ok) {
                alert("Connexion réussie !");
            } else {
                alert("Erreur lors de la connexion.");
            }
        } catch (error) {
            // Gestion des erreurs réseau
            console.error("Erreur de communication avec le serveur :", error);
        }
    });
}