import React, { useEffect, useState } from 'react';

function JoueurList() {
  const [joueurs, setJoueurs] = useState([]);

  useEffect(() => {
    // Effectue la requête GET au chargement du composant
    fetch('http://localhost:8081/joueurs')
      .then(response => response.json())
      .then(data => {
        // Met à jour le state avec les données des joueurs
        setJoueurs(data);
      })
      .catch(error => {
        console.error('Erreur lors de la récupération des joueurs:', error);
      });
  }, []);

  return (
    <div>
      <h1>Liste des joueurs</h1>
      <ul>
        {joueurs.map(joueur => (
          <li key={joueur.id}>
            <p>Équipe : {joueur.equipe}</p>
            <p>Taille : {joueur.taille}</p>
            <p>Poids : {joueur.poids}</p>
            <p>Poste : {joueur.poste}</p>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default JoueurList;