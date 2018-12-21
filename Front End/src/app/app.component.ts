import { Component } from '@angular/core';
import { ILivre } from './livre.model';
import { Livre } from './livre.model';
import { LivreService } from './livre.service';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import {PLivre} from './livre-panier.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'BibLo';
  alphabet:String[]=["A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"]
  livres: ILivre[];
  panier: PLivre[];
  genres: String[];
  nbrLivre: number;
	livre: ILivre;
	showPanier : boolean = false;

	total:any;

  constructor( private livreService: LivreService){

  }
  ngOnInit() {
    this.livre = new Livre();
    this.panier = [];
    this.nbrLivre = 0;
    this.total=0;
    this.loadAll();
    this.loadAllGenre();

  }

private onError(errorMessage: string) {
  console.log("Erreur lors du chargement ",errorMessage);
}


search(){
  this.showPanier=false;
	var req = ''
	if (this.livre.titre) {

                    req = 'titre=' + this.livre.titre;
                    //req+'titre=' + this.livre.auteur
       }


  if (this.livre.auteur) {
        if (req !== '')
           req = req + '&';
         req= req+'auteur=' + this.livre.auteur;
        }

	this.livreService
            .search(req).subscribe(
                (res: HttpResponse<ILivre[]>) => { this.livres = res.body; console.log(this.livres)},
                (res: HttpErrorResponse) => this.onError(res.message)
            );
  	}

  findAllByGenre(genre: any){
    this.livreService
      .findByGenre(genre).subscribe(
      (res: HttpResponse<ILivre[]>) => {this.livres = res.body; console.log("liste de livre ",this.livres)},
      (res: HttpErrorResponse) => this.onError(res.message)
    );
  }

  findAllByAlphabet(alphabet: any){
    this.showPanier=false;
    this.livreService
      .findByAlphabet(alphabet).subscribe(
      (res: HttpResponse<ILivre[]>) => {this.livres = res.body; console.log("liste de livre ",this.livres)},
      (res: HttpErrorResponse) => this.onError(res.message)
    );
  }

  loadAll() {
    this.livreService
        .query().subscribe(
            (res: HttpResponse<ILivre[]>) => {this.livres = res.body; console.log("liste de livre ",this.livres)},
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    loadAllGenre(){
      this.livreService
      .getAllGenre().subscribe(
          (res: HttpResponse<String[]>) => {this.genres = res.body; console.log(this.genres)},
          (res: HttpErrorResponse) => this.onError(res.message)
      );

    }

  addToPanier(livre: any) {

    const index = this.findIndex(livre);
    if(index != -1)
      this.panier[index].qte++;
    else
      this.panier.push(new PLivre(livre,1));
    this.nbrLivre++;

    this.calculTotalPanier();
  }

  findIndex(livre){
    return this.panier.findIndex( x => x.livre === livre);

  }

  incrementQte(index : any){

    this.panier[index].qte++;
    this.nbrLivre++;
    this.calculTotalPanier();

  }


  decrementQte(index : any){

    if(this.panier[index].qte >1) {
      this.panier[index].qte--;
      this.nbrLivre--;
      this.calculTotalPanier();
    }

}

 calculTotalPanier(){
    this.total=0;
    for(const p of this.panier){
      this.total += p.qte * p.livre.prix;
    }
 }

 removeLivre(index: any){
	  this.panier.splice(index,1);
	  this.calculTotalPanier();
	  this.nbrLivre=this.panier.length;
 }

}


