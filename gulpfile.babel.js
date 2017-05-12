import path from 'path';
import gulp from 'gulp';
import babel from 'gulp-babel';
import sourcemaps from 'gulp-sourcemaps';
import sass from 'gulp-sass';
import autoprefixer from 'gulp-autoprefixer';
import del from 'del';
import chalk from 'chalk';

const clean ='clean';
const clean_dir_pattern = [
    './build/resources/**/*.js.map',
    './build/resources/**/*.css.map',
    './build/resources/**/*.scss'
];
gulp.task(clean, () => {
    return del.sync(clean_dir_pattern);
});

const js = 'javascripts';
const source_pattern_of_js = './src/main/resources/static/javascripts/**/*.js';
const destin_pattern_of_js = './build/resources/main/static/javascripts';
gulp.task(js, () => {
    return gulp.src(source_pattern_of_js)
        .pipe(sourcemaps.init())
        .pipe(babel({
            presets: ['env']
        }))
        .pipe(sourcemaps.write('.'))
        .pipe(gulp.dest(destin_pattern_of_js));
});

const scss = 'stylesheets:sass';
const source_pattern_of_sass = './src/main/resources/static/stylesheets/**/*.scss';
const destin_pattern_of_sass = './build/resources/main/static/stylesheets';
gulp.task(scss, () => {
    return gulp.src(source_pattern_of_sass)
        .pipe(sourcemaps.init())
        .pipe(sass().on('error', sass.logError))
        .pipe(autoprefixer({cascade: false}))
        .pipe(sourcemaps.write('.'))
        .pipe(gulp.dest(destin_pattern_of_sass));
});

const css = 'stylesheets:css';
const source_pattern_of_css = './src/main/resources/static/stylesheets/**/*.css';
const destin_pattern_of_css = './build/resources/main/static/stylesheets';
gulp.task(css, () => {
    return gulp.src(source_pattern_of_css)
        .pipe(sourcemaps.init())
        .pipe(autoprefixer({cascade: false}))
        .pipe(sourcemaps.write('.'))
        .pipe(gulp.dest(destin_pattern_of_css));
});

const templates = 'templates';
const source_pattern_of_templates = './src/main/resources/templates/**/*.html';
const destin_pattern_of_templates = './build/resources/main/templates';
gulp.task(templates, () => {
    return gulp.src(source_pattern_of_templates)
        .pipe(gulp.dest(destin_pattern_of_templates));
});

const properties = 'properties';
const source_pattern_of_properties = './src/main/resources/**/*.properties';
const destin_pattern_of_properties = './build/resources/main';
gulp.task(properties, () => {
    return gulp.src(source_pattern_of_properties)
        .pipe(gulp.dest(destin_pattern_of_properties));
});

const preprocess = 'preprocess';
gulp.task(preprocess, [clean, js, css, scss, templates], () => {
    console.log(chalk.green.underline('<resources pre-processed.>'));
});

