import {Component, OnInit} from '@angular/core';
import {Movie} from './movie.model';
import {MovieService} from './movie.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  searchTerm: string;

  movies: Movie[];

  constructor(private movieService: MovieService) {

  }

  ngOnInit(): void {
    this.movieService.listMovies().subscribe((movies) => this.movies = movies)
  }

  onSearch() {
    this.movieService.searchMovies(this.searchTerm).subscribe((movies) => this.movies = movies);
  }

}
