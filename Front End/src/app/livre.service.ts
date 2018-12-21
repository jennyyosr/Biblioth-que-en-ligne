import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { ILivre } from './livre.model';



type EntityResponseType = HttpResponse<ILivre>;
type EntityArrayResponseType = HttpResponse<ILivre[]>;

@Injectable({ providedIn: 'root' })
export class LivreService {
    private resourceUrl = 'http://localhost:8080/api/livres';

    constructor(private http: HttpClient) {}

    create(livre: ILivre): Observable<EntityResponseType> {
        return this.http.post<ILivre>(this.resourceUrl, livre, { observe: 'response' });
    }

    update(livre: ILivre): Observable<EntityResponseType> {
        return this.http.put<ILivre>(this.resourceUrl, livre, { observe: 'response' });
    }

    find(id: any): Observable<EntityResponseType> {
        return this.http.get<ILivre>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

   findByGenre(genre: any): Observable<EntityArrayResponseType> {
    return this.http.get<ILivre[]>(this.resourceUrl + '/genre/' + genre, { observe: 'response' });
  }
  findByAlphabet (alphabet: any): Observable<EntityArrayResponseType> {
    return this.http.get<ILivre[]>(this.resourceUrl + '/alphabet/' + alphabet, { observe: 'response' });
  }
    query(): Observable<EntityArrayResponseType> {
        return this.http.get<ILivre[]>(this.resourceUrl, {observe: 'response' });
    }

     getAllGenre(): Observable<HttpResponse<String[]>> {
        return this.http.get<String[]>(this.resourceUrl+'/genres', {observe: 'response' });
    }

    search(req?: any): Observable<EntityArrayResponseType> {
        return this.http.get<ILivre[]>(this.resourceUrl + '/search?' + req, {observe: 'response' });
    }

    delete(id: any): Observable<HttpResponse<any>> {
        return this.http.delete<any>(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }
}
