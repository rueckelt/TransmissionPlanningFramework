
% 2015-10-17 01:03:47

% my_logs\longTest1\2_0_0\rep_10\optimization_log.m
scheduling_duration_us = 129924;

% schedule
schedule_f_t_n(:,:,1) = [0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0];
schedule_f_t_n(:,:,2) = [0; 0; 0; 0; 25; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0];
schedule_f_t_n(:,:,3) = [0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0];
schedule_f_t_n(:,:,4) = [0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 39; 39; 39; 39; 39; 39; 39; 39; 39; 39; 39];

% cost function results
vioSt = [0, 0, 0, 2730];
vioDl = [0, 0, 0, 351];
vioNon = [6804, 0, 56, 3591];
vioTpMin = [5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
vioTp = [10500, 0, 0, 0];
vioLcy = [0, 0, 0, 0];
vioJit = [0, 0, 0, 0];
cost_vio = 215840;
cost_switches = 0;
cost_ch = 3178;
costTotal = 219018;

% optimization
% 
% ############### Network 0 ##############
% F1	|[0]	|	|	|	|25	|	|	|	|	|	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
% F3	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|	|	|39	|39	|39	|39	|39	|39	|[20]39	|39	|39	|39	|39	|
