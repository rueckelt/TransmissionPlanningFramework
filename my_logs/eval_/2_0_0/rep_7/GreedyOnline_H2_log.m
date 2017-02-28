
% 2016-12-02 16:24:19

% my_logs/eval_/2_0_0/rep_7/GreedyOnline_H2_log.m
scheduling_duration_us = 3130;

% schedule
schedule_f_t_n(:,:,1) = [0; 0; 0; 0; 0; 0; 0; 35; 35; 35; 20; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0];
schedule_f_t_n(:,:,2) = [46; 46; 46; 35; 35; 35; 35; 0; 0; 0; 15; 35; 35; 35; 0; 17; 46; 0; 0; 0; 0; 0; 0; 0; 0];
schedule_f_t_n(:,:,3) = [0; 0; 0; 11; 11; 11; 11; 11; 11; 11; 11; 11; 11; 11; 11; 11; 0; 0; 0; 0; 0; 0; 0; 0; 0];
schedule_f_t_n(:,:,4) = [0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 35; 18; 0; 0; 0; 0; 0; 0; 0; 0; 0];

% cost function results
vioSt = [0, 0, 0, 0];
vioDl = [0, 0, 0, 0];
vioNon = [0, 102, 400, 0];
vioTpMin = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0];
vioTp = [0, 0, 0, 680];
vioLcy = [0, 0, 6656, 0];
vioJit = [0, 0, 1872, 0];
cost_vio = 96182;
cost_switches = 0;
cost_ch = 175950;
costTotal = 272132;

% GreedyOnline_H2
% 
% ############### Network 0 ##############
% cap	|[0]46	|46	|46	|46	|46	|46	|46	|46	|46	|46	|[10]46	|46	|46	|46	|46	|46	|46	|46	|46	|46	|[20]46	|46	|46	|46	|46	|
% F0	|[0]	|	|	|	|	|	|	|35	|35	|35	|[10]20	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
% F1	|[0]46	|46	|46	|35	|35	|35	|35	|	|	|	|[10]15	|35	|35	|35	|	|17	|46	|	|	|	|[20]	|	|	|	|	|
% F2	|[0]	|	|	|11	|11	|11	|11	|11	|11	|11	|[10]11	|11	|11	|11	|11	|11	|	|	|	|	|[20]	|	|	|	|	|
% F3	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|	|	|35	|18	|	|	|	|	|[20]	|	|	|	|	|
